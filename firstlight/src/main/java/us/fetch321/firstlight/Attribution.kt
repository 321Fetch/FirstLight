package us.fetch321.firstlight

/**
 * An attribution for code or a font
 */
data class Attribution (
        val type: Type,
        val title: String,
        val licenseLink: String
) {
    enum class Type(val title: String) {
        CODE("Code"),
        FONT("Fonts"),
        IMAGE("Images"),
        VIDEO("Videos")
    }
}