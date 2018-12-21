package com.sfl.qup.tms

import com.google.gson.Gson
import com.sfl.qup.tms.service.translatablestatic.TranslatableStaticService
import com.sfl.qup.tms.service.translatablestatic.dto.TranslatableStaticDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class TmsApplication {

    //region Injection

    @Autowired
    private lateinit var translatableStaticService: TranslatableStaticService

    //endregion

    @Bean
    fun init(): CommandLineRunner = CommandLineRunner {
        insertData("en")
        insertData("nl")
    }

    private fun insertData(lang: String) {
        val fromJson = Gson().fromJson(TmsApplication::class.java.getResource("/static/locales-$lang.json").readText(), Map::class.java)

        fromJson.forEach { k, v ->
            if (v is Map<*, *>) {
                v.forEach { k2, v2 ->

                    val key = k as String + "_" + k2 as String
                    val value = v2 as String

                    createOrUpdateIfExist(key, lang, value)
                }
            } else {
                val key = k as String
                val value = v as String

                createOrUpdateIfExist(key, lang, value)
            }
        }
    }

    private fun createOrUpdateIfExist(key: String, lang: String, value: String) = TranslatableStaticDto(key, value, lang).let {
        if (translatableStaticService.findByKeyAndLanguageLang(it.key, it.lang) == null) {
            translatableStaticService.create(it)
        } else {
            translatableStaticService.updateValue(it)
        }
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(TmsApplication::class.java, *args)
        }
    }
}
