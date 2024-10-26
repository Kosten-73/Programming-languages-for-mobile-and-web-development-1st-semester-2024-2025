import java.util.*

/**
 * Класс `Telephone` представляет телефон с возможностью совершения и принятия вызовов.
 * Телефон имеет параметры, такие как бренд, номер телефона, список запомненных номеров,
 * количество вызовов и тариф на звонки.
 */
class Telephone {
    /**
     * Возвращает название бренда телефона.
     *
     * @return Бренд телефона.
     */
    /**
     * Устанавливает название бренда телефона.
     *
     * @param brand Бренд телефона.
     */
    /** Бренд телефона.  */
    var brand: String
    /**
     * Возвращает номер телефона.
     *
     * @return Номер телефона.
     */
    /**
     * Устанавливает номер телефона.
     *
     * @param my_number Номер телефона.
     */
    /** Личный номер телефона.  */
    var my_number: Long
    /**
     * Возвращает список запомненных номеров.
     *
     * @return Список запомненных номеров.
     */
    /**
     * Устанавливает список запомненных номеров.
     *
     * @param remembered_numbers Список запомненных номеров.
     */
    /** Список запомненных номеров.  */
    var remembered_numbers: ArrayList<Long>
    /**
     * Возвращает количество вызовов.
     *
     * @return Количество вызовов.
     */
    /**
     * Устанавливает количество вызовов.
     *
     * @param count_calls Количество вызовов.
     */
    /** Количество вызовов, совершенных с телефона.  */
    var count_calls: Int
    /**
     * Возвращает тариф за минуту разговора.
     *
     * @return Тариф за минуту.
     */
    /**
     * Устанавливает тариф за минуту разговора.
     *
     * @param tariff Тариф за минуту разговора.
     */
    /** Тариф за минуту разговора.  */
    var tariff: Double

    private var number_to: Long? = null

    /**
     * Конструктор класса `Telephone`, который инициализирует телефон с заданным брендом.
     * Генерируется случайный номер телефона и тариф.
     *
     * @param brand Название бренда телефона.
     */
    constructor(brand: String) {
        val random = Random()
        this.brand = brand
        this.my_number = 1000000000L + random.nextLong(9000000000L)
        this.remembered_numbers = ArrayList()
        this.count_calls = 0
        this.tariff = Math.round((0.1 + random.nextDouble() * 0.9) * 10.0) / 10.0
    }

    /**
     * Конструктор класса `Telephone`, который инициализирует телефон с заданным брендом и номером.
     *
     * @param brand     Название бренда телефона.
     * @param my_number Личный номер телефона.
     */
    constructor(brand: String, my_number: Long) {
        val random = Random()
        this.brand = brand
        this.my_number = my_number
        this.remembered_numbers = ArrayList()
        this.count_calls = 0
        this.tariff = Math.round((0.1 + random.nextDouble() * 0.9) * 10.0) / 10.0
    }

    /**
     * Преобразует строку в число типа `Long`, извлекая только цифры.
     *
     * @param stri Входная строка, содержащая цифры.
     * @return Число типа `Long`, содержащее только цифры из строки.
     */
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

    /**
     * Конструктор класса `Telephone`, который инициализирует телефон с брендом и номером, представленным строкой.
     *
     * @param brand     Название бренда телефона.
     * @param my_number Номер телефона в виде строки.
     */
    constructor(brand: String, my_number: String) {
        val random = Random()
        this.brand = brand
        this.my_number = str_to_long(my_number)
        this.remembered_numbers = ArrayList()
        this.count_calls = 0
        this.tariff = Math.round((0.1 + random.nextDouble() * 0.9) * 10.0) / 10.0
    }

    /**
     * Конструктор класса `Telephone`, который инициализирует телефон с заданными параметрами.
     *
     * @param brand              Название бренда телефона.
     * @param my_number          Номер телефона в виде строки.
     * @param remembered_numbers Список запомненных номеров.
     * @param count_calls        Количество вызовов.
     * @param tariff             Тариф за минуту разговора.
     */
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

    /**
     * Совершает звонок на другой телефон и обновляет список запомненных номеров.
     *
     * @param telephoneToCall Телефон, на который совершается вызов.
     */
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

        this.number_to = telephoneToCall.my_number
        count_calls++
    }


    fun toAnswer(telephoneToAnswer: Telephone, duration: Int) {
        if (telephoneToAnswer.number_to === this.my_number) {
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