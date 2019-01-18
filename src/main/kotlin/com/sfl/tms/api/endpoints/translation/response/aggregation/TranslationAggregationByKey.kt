package com.sfl.tms.api.endpoints.translation.response.aggregation

/**
 * User: Vazgen Danielyan
 * Date: 1/18/19
 * Time: 12:39 PM
 */
data class TranslationAggregationByKey(val key: String, val translations: List<TranslationLanguageValuePair>)