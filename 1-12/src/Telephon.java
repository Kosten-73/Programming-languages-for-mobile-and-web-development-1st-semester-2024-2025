import com.sun.jdi.LongValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Character.isDigit;

public class Telephon {
    private String brand;
    private Long my_number;
    private ArrayList<Long> remembered_numbers;
    private int count_calls;
    private double tariff;



    public Telephon(String brand) {
        Random random = new Random();
        this.brand = brand;
        this.my_number = 1000000000L + random.nextLong(9000000000L);;
        this.remembered_numbers =  new ArrayList<Long>();
        this.count_calls = 0;
        this.tariff = Math.round((0.1 + random.nextDouble() * 0.9) * 10.0) / 10.0;
    }

    public Telephon(String brand, Long my_number) {
        Random random = new Random();
        this.brand = brand;
        this.my_number = my_number;
        this.remembered_numbers = new ArrayList<Long>();
        this.count_calls = 0;
        this.tariff = Math.round((0.1 + random.nextDouble() * 0.9) * 10.0) / 10.0;
    }

    public Long str_to_long(String stri){
        long out_nub = 0;
        for (Character ch: stri.toCharArray()
             ) {
                if (isDigit(ch)){
                    if (out_nub == 0) {out_nub = Character.getNumericValue(ch);}
                    else {
                        out_nub = out_nub * 10 + Character.getNumericValue(ch);
                    }

                }
        }
        return out_nub;
    }

    public Telephon(String brand, String my_number) {
        Random random = new Random();
        this.brand = brand;
        this.my_number = str_to_long(my_number);
        this.remembered_numbers = new ArrayList<Long>();
        this.count_calls = 0;
        this.tariff = Math.round((0.1 + random.nextDouble() * 0.9) * 10.0) / 10.0;
    }

    public Telephon(String brand, String my_number, ArrayList<Long> remembered_numbers, int count_calls, double tariff) {
        this.brand = brand;
        this.my_number = str_to_long(my_number);
        this.remembered_numbers = remembered_numbers;
        this.count_calls = count_calls;
        this.tariff = tariff;
    }

    public static void toCall(Telephon telephonToCall, Telephon telephonToanswer){
        if (!telephonToCall.remembered_numbers.stream().equals(telephonToanswer.my_number)){
            telephonToCall.remembered_numbers.add(telephonToanswer.my_number);
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getMy_number() {
        return my_number;
    }

    public void setMy_number(Long my_number) {
        this.my_number = my_number;
    }

    public ArrayList<Long> getRemembered_numbers() {
        return remembered_numbers;
    }

    public void setRemembered_numbers(ArrayList<Long> remembered_numbers) {
        this.remembered_numbers = remembered_numbers;
    }

    public int getCount_calls() {
        return count_calls;
    }

    public void setCount_calls(int count_calls) {
        this.count_calls = count_calls;
    }

    public double getTariff() {
        return tariff;
    }

    public void setTariff(double tariff) {
        this.tariff = tariff;
    }

    @Override
    public String toString() {
        return "Телефон{ " +
                "брент: " + brand +
                ", номер телефона = " + my_number +
                ", телефонная книга = " + remembered_numbers +
                ", количество вызовов = " + count_calls +
                ", тариф = " + tariff +
                '}';
    }
}
