package com.sfl.qup.tms.api.endpoints.translation.error

import com.sfl.qup.tms.api.common.model.error.type.ErrorType

/**
 * User: Vazgen Danielyan
 * Date: 12/5/18
 * Time: 4:26 PM
 */
enum class TranslationControllerErrorType : ErrorType {
    TRANSLATABLE_ENTITY_UUID_MISSING,
    TRANSLATABLE_ENTITY_NAME_MISSING,

    TRANSLATABLE_ENTITY_FIELD_NAME_MISSING,

    TRANSLATABLE_ENTITY_TRANSLATIONS_MISSING,
    TRANSLATABLE_ENTITY_TRANSLATION_TEXT_MISSING,
    TRANSLATABLE_ENTITY_TRANSLATION_LANG_MISSING
}