import java.util.ArrayList;
import java.util.Random;

import static java.lang.Character.isDigit;

/**
 * Класс {@code Telephone} представляет телефон с возможностью совершения и принятия вызовов.
 * Телефон имеет параметры, такие как бренд, номер телефона, список запомненных номеров,
 * количество вызовов и тариф на звонки.
 */
public class Telephone {
    /** Бренд телефона. */
    private String brand;
    /** Личный номер телефона. */
    private Long my_number;
    /** Список запомненных номеров. */
    private ArrayList<Long> remembered_numbers;
    /** Количество вызовов, совершенных с телефона. */
    private int count_calls;
    /** Тариф за минуту разговора. */
    private double tariff;

    private Long number_to;

    /**
     * Конструктор класса {@code Telephone}, который инициализирует телефон с заданным брендом.
     * Генерируется случайный номер телефона и тариф.
     *
     * @param brand Название бренда телефона.
     */
    public Telephone(String brand) {
        Random random = new Random();
        this.brand = brand;
        this.my_number = 1000000000L + random.nextLong(9000000000L);
        this.remembered_numbers = new ArrayList<>();
        this.count_calls = 0;
        this.tariff = Math.round((0.1 + random.nextDouble() * 0.9) * 10.0) / 10.0;
    }

    /**
     * Конструктор класса {@code Telephone}, который инициализирует телефон с заданным брендом и номером.
     *
     * @param brand     Название бренда телефона.
     * @param my_number Личный номер телефона.
     */
    public Telephone(String brand, Long my_number) {
        Random random = new Random();
        this.brand = brand;
        this.my_number = my_number;
        this.remembered_numbers = new ArrayList<>();
        this.count_calls = 0;
        this.tariff = Math.round((0.1 + random.nextDouble() * 0.9) * 10.0) / 10.0;
    }

    /**
     * Преобразует строку в число типа {@code Long}, извлекая только цифры.
     *
     * @param stri Входная строка, содержащая цифры.
     * @return Число типа {@code Long}, содержащее только цифры из строки.
     */
    public Long str_to_long(String stri) {
        long out_nub = 0;
        for (Character ch : stri.toCharArray()) {
            if (isDigit(ch)) {
                if (out_nub == 0) {
                    out_nub = Character.getNumericValue(ch);
                } else {
                    out_nub = out_nub * 10 + Character.getNumericValue(ch);
                }
            }
        }
        return out_nub;
    }

    /**
     * Конструктор класса {@code Telephone}, который инициализирует телефон с брендом и номером, представленным строкой.
     *
     * @param brand     Название бренда телефона.
     * @param my_number Номер телефона в виде строки.
     */
    public Telephone(String brand, String my_number) {
        Random random = new Random();
        this.brand = brand;
        this.my_number = str_to_long(my_number);
        this.remembered_numbers = new ArrayList<>();
        this.count_calls = 0;
        this.tariff = Math.round((0.1 + random.nextDouble() * 0.9) * 10.0) / 10.0;
    }

    /**
     * Конструктор класса {@code Telephone}, который инициализирует телефон с заданными параметрами.
     *
     * @param brand              Название бренда телефона.
     * @param my_number          Номер телефона в виде строки.
     * @param remembered_numbers Список запомненных номеров.
     * @param count_calls        Количество вызовов.
     * @param tariff             Тариф за минуту разговора.
     */
    public Telephone(String brand, String my_number, ArrayList<Long> remembered_numbers, int count_calls, double tariff) {
        this.brand = brand;
        this.my_number = str_to_long(my_number);
        this.remembered_numbers = remembered_numbers;
        this.count_calls = count_calls;
        this.tariff = tariff;
    }

    /**
     * Совершает звонок на другой телефон и обновляет список запомненных номеров.
     *
     * @param telephoneToCall Телефон, на который совершается вызов.
     */
    public void toCall(Telephone telephoneToCall) {
        System.out.println(this.brand + " звонит на номер " + telephoneToCall.my_number);

        try {
            if (!this.remembered_numbers.contains(telephoneToCall.my_number)) {
                this.remembered_numbers.add(telephoneToCall.my_number);
                System.out.println("Номер " + telephoneToCall.my_number + " добавлен в список запомненных номеров.");
            } else {
                System.out.println("Номер " + telephoneToCall.my_number + " уже есть в списке.");
            }
        } catch (NullPointerException e) {
            System.err.println("Ошибка: список номеров не инициализирован.");
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }

        this.number_to = telephoneToCall.getMy_number();
        this.count_calls++;
    }

    /**
     * Принимает вызов от другого телефона и вычисляет стоимость разговора.
     *
     * @param telephoneToAnswer Телефон, с которого поступил вызов.
     * @param duration          Продолжительность вызова в минутах.
     */
    public void toAnswer(Telephone telephoneToAnswer, int duration) {
        System.out.println(telephoneToAnswer.number_to + " отвечает на номер " + this.my_number);
        if (telephoneToAnswer.number_to == this.my_number){
        System.out.println(this.brand + " отвечает на вызов от номера " + telephoneToAnswer.my_number);

        if (!this.remembered_numbers.contains(telephoneToAnswer.my_number)) {
            this.remembered_numbers.add(telephoneToAnswer.my_number);
            System.out.println("Номер " + telephoneToAnswer.my_number + " добавлен в список запомненных номеров.");
        } else {
            System.out.println("Номер " + telephoneToAnswer.my_number + " уже есть в списке.");
        }

        this.count_calls++;

        double callCost = duration * telephoneToAnswer.tariff;
        System.out.println("Продолжительность разговора: " + duration + " минут.");
        System.out.println("Стоимость разговора: " + callCost + " у.е.");
        telephoneToAnswer.number_to = null;
        }
        else {
            System.out.println("С номера " + duration + " не было звонка");
        }
        }

    public Long getNumber_to() {
        return number_to;
    }

    public void setNumber_to(Long number_to) {
        this.number_to = number_to;
    }




    /**
     * Возвращает название бренда телефона.
     *
     * @return Бренд телефона.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Устанавливает название бренда телефона.
     *
     * @param brand Бренд телефона.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Возвращает номер телефона.
     *
     * @return Номер телефона.
     */
    public Long getMy_number() {
        return my_number;
    }

    /**
     * Устанавливает номер телефона.
     *
     * @param my_number Номер телефона.
     */
    public void setMy_number(Long my_number) {
        this.my_number = my_number;
    }

    /**
     * Возвращает список запомненных номеров.
     *
     * @return Список запомненных номеров.
     */
    public ArrayList<Long> getRemembered_numbers() {
        return remembered_numbers;
    }

    /**
     * Устанавливает список запомненных номеров.
     *
     * @param remembered_numbers Список запомненных номеров.
     */
    public void setRemembered_numbers(ArrayList<Long> remembered_numbers) {
        this.remembered_numbers = remembered_numbers;
    }

    /**
     * Возвращает количество вызовов.
     *
     * @return Количество вызовов.
     */
    public int getCount_calls() {
        return count_calls;
    }

    /**
     * Устанавливает количество вызовов.
     *
     * @param count_calls Количество вызовов.
     */
    public void setCount_calls(int count_calls) {
        this.count_calls = count_calls;
    }

    /**
     * Возвращает тариф за минуту разговора.
     *
     * @return Тариф за минуту.
     */
    public double getTariff() {
        return tariff;
    }

    /**
     * Устанавливает тариф за минуту разговора.
     *
     * @param tariff Тариф за минуту разговора.
     */
    public void setTariff(double tariff) {
        this.tariff = tariff;
    }

    /**
     * Возвращает строковое представление объекта {@code Telephone}.
     *
     * @return Строка, описывающая параметры телефона.
     */
    @Override
    public String toString() {
        return "Телефон{ " +
                "бренд: " + brand +
                ", номер телефона = " + my_number +
                ", телефонная книга = " + remembered_numbers +
                ", количество вызовов = " + count_calls +
                ", тариф = " + tariff +
                '}';
    }
}
