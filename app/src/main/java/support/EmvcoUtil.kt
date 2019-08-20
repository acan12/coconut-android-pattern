package support

object EmvcoUtil {

    fun parseEMVCOByTags(data: String, tags: List<String>): List<String> {

        var dataList: MutableList<String> = ArrayList()
        var usedTagContainer: MutableList<String> = ArrayList()
        var tagCount = tags.size
        var length: String
        var cursor = 0
        var tagCursor = 0
        var currTag: String
        while (cursor < data.length) {
            currTag = data.substring(cursor, cursor + 2)
            if (isNumeric(currTag) && currTag != tags[tagCursor]) {
                cursor += 2
                length = data.substring(cursor, cursor + 2)
                if (isNumeric(length)) {
                    dataList.add(data.substring(cursor, cursor + Integer.parseInt(length)))
                    cursor += Integer.parseInt(length)
                    tagCount += 1
                    usedTagContainer.add(currTag)
                }
            }
            if (tagCount == tagCursor)
                break
        }
        return dataList
    }

    fun isNumeric(str: String): Boolean {
        return str.matches("-?\\d+(\\.\\d+)?".toRegex())
    }

}