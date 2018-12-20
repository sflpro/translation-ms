package com.sfl.qup.tms.service.translatable.field

import com.sfl.qup.tms.domain.translatable.TranslatableEntityField
import com.sfl.qup.tms.service.translatable.field.dto.TranslatableEntityFieldDto

/**
 * User: Vazgen Danielyan
 * Date: 12/4/18
 * Time: 6:11 PM
 */
interface TranslatableEntityFieldService {

    fun findByNameAndEntityUuid(name: String, entityUuid: String): TranslatableEntityField?

    fun getByNameAndEntityUuid(name: String, entityUuid: String): TranslatableEntityField

    fun create(dto: TranslatableEntityFieldDto): TranslatableEntityField
}