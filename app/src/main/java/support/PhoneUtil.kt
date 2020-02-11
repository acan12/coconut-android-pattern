package support

open class PhoneUtil {

    companion object {
        fun countryCodeReplaceWithZero(number: String): String {
            var validNumber = number.replace("[^0-9]".toRegex(), "")

            if ("0" != validNumber.substring(0, 1)) {
                val tempNumber = validNumber.substring(2)
                validNumber = "0$tempNumber"
            }
            return validNumber
        }
    }
}