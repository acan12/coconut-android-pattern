package support

object FormValidation {

    fun required(value: String): Boolean {
        return if (value.trim { it <= ' ' }.length > 0) {
            true
        } else false
    }

    fun validEmail(email: String): Boolean {
        val validEmail = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        return if (validEmail) {
            true
        } else false
    }

    fun validPhone(phone: String): Boolean {
        return if (phone.trim { it <= ' ' }.length > 9) {
            true
        } else false
    }

    fun validKodePos(input: String): Boolean {
        return if (input.trim { it <= ' ' }.length == 5) {
            true
        } else false
    }

    fun validNoKTP(input: String): Boolean {
        return if (input.trim { it <= ' ' }.length == 16) {
            true
        } else false
    }

    fun validKodePelanggan(input: String): Boolean {
        return if (input.trim { it <= ' ' }.length > 5) {
            true
        } else false
    }

    fun validKodePelangganPLN(input: String): Boolean {
        return if (input.trim { it <= ' ' }.length > 9) {
            true
        } else false
    }

    fun validPin(pin: String): Boolean {
        return if (pin.trim { it <= ' ' }.length == 6) {
            true
        } else false
    }

    fun validUsername(username: String): Boolean {
        return if (username.trim { it <= ' ' }.length > 3) {
            true
        } else false
    }

    fun validAmount(input: String): Boolean {
        return if (input.trim { it <= ' ' }.length > 2) {
            true
        } else false
    }

    fun validNominalPHL(input: String): Boolean {
        return if (Integer.valueOf(input.trim { it <= ' ' }) >= 1000) {
            true
        } else false
    }

    fun validFullname(input: String): Boolean {
        val result = input.replace("[^a-zA-Z\\s]".toRegex(), "")

        val originalLeng = input.length
        val newLeng = result.length

        return if (originalLeng == newLeng) {
            true
        } else false
    }

    fun textExistInArray(input: String, data: List<String>): Boolean {
        return if (data.contains(input))
            true
        else
            false


    }
}