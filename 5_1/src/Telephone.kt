import java.util.*


class Telephone {

    var brand: String

    var my_number: Long

    var remembered_numbers: ArrayList<Long>

    var count_calls: Int

    var tariff: Double

    private var number_to: Long? = null

    constructor(brand: String) {
        val random = Random()
        this.brand = brand
        this.my_number = 1000000000L + random.nextLong(9000000000L)
        this.remembered_numbers = ArrayList()
        this.count_calls = 0
        this.tariff = Math.round((0.1 + random.nextDouble() * 0.9) * 10.0) / 10.0
    }


    constructor(brand: String, my_number: Long) {
        val random = Random()
        this.brand = brand
        this.my_number = my_number
        this.remembered_numbers = ArrayList()
        this.count_calls = 0
        this.tariff = Math.round((0.1 + random.nextDouble() * 0.9) * 10.0) / 10.0
    }


    fun str_to_long(stri: String): Long {
        var out_nub: Long = 0
        for (ch in stri.toCharArray()) {
            if (Character.isDigit(ch)) {
                out_nub = if (out_nub == 0L) {
                    Character.getNumericValue(ch).toLong()
                } else {
                    out_nub * 10 + Character.getNumericValue(ch)
                }
            }
        }
        return out_nub
    }

    constructor(brand: String, my_number: String) {
        val random = Random()
        this.brand = brand
        this.my_number = str_to_long(my_number)
        this.remembered_numbers = ArrayList()
        this.count_calls = 0
        this.tariff = Math.round((0.1 + random.nextDouble() * 0.9) * 10.0) / 10.0
    }

    constructor(
        brand: String,
        my_number: String,
        remembered_numbers: ArrayList<Long>,
        count_calls: Int,
        tariff: Double
    ) {
        this.brand = brand
        this.my_number = str_to_long(my_number)
        this.remembered_numbers = remembered_numbers
        this.count_calls = count_calls
        this.tariff = tariff
    }

    fun toCall(telephoneToCall: Telephone) {
        println(this.brand + " звонит на номер " + telephoneToCall.my_number)

        try {
            if (!remembered_numbers.contains(telephoneToCall.my_number)) {
                remembered_numbers.add(telephoneToCall.my_number)
                println("Номер " + telephoneToCall.my_number + " добавлен в список запомненных номеров.")
            } else {
                println("Номер " + telephoneToCall.my_number + " уже есть в списке.")
            }
        } catch (e: NullPointerException) {
            System.err.println("Ошибка: список номеров не инициализирован.")
        } catch (e: Exception) {
            System.err.println("Произошла непредвиденная ошибка: " + e.message)
        }

        this.number_to = telephoneToCall.getMy_number()
        this.count_calls++
    }

    fun getMy_number(): Long? {
        return my_number
    }

    fun toAnswer(telephoneToAnswer: Telephone, duration: Int) {
        if (telephoneToAnswer.number_to == this.my_number) {
            println(this.brand + " отвечает на вызов от номера " + telephoneToAnswer.my_number)

            if (!remembered_numbers.contains(telephoneToAnswer.my_number)) {
                remembered_numbers.add(telephoneToAnswer.my_number)
                println("Номер " + telephoneToAnswer.my_number + " добавлен в список запомненных номеров.")
            } else {
                println("Номер " + telephoneToAnswer.my_number + " уже есть в списке.")
            }

            count_calls++

            val callCost = duration * telephoneToAnswer.tariff
            println("Продолжительность разговора: $duration минут.")
            println("Стоимость разговора: $callCost у.е.")
            telephoneToAnswer.number_to = null
        } else {
            println("С номера $duration не было звонка")
        }
    }

    fun getNumber_to(): Long? {
        return number_to
    }

    fun setNumber_to(number_to: Long?) {
        this.number_to = number_to
    }


    /**
     * Возвращает строковое представление объекта `Telephone`.
     *
     * @return Строка, описывающая параметры телефона.
     */
    override fun toString(): String {
        return "Телефон{ " +
                "бренд: " + brand +
                ", номер телефона = " + my_number +
                ", телефонная книга = " + remembered_numbers +
                ", количество вызовов = " + count_calls +
                ", тариф = " + tariff +
                '}'
    }
}