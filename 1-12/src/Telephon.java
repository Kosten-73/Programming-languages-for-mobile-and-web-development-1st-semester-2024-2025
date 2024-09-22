import com.sun.jdi.LongValue;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Character.isDigit;

public class Telephon {
    private String brand;
    private Long my_number;
    private int[] remembered_numbers;
    private int count_calls;
    private double tariff;

    public Telephon(String brand) {
        Random random = new Random();
        this.brand = brand;
        this.my_number = 1000000000L + random.nextLong(9000000000L);;
        this.remembered_numbers = new int[0];
        this.count_calls = 0;
        this.tariff = 0.1 + random.nextDouble() * 0.9;
    }

    public Telephon(String brand, Long my_number) {
        Random random = new Random();
        this.brand = brand;
        this.my_number = my_number;
        this.remembered_numbers = new int[0];
        this.count_calls = 0;
        this.tariff = 0.1 + random.nextDouble() * 0.9;
    }

    public Long str_to_long(String stri){
        long out_nub = 0;
        for (Character ch: stri.toCharArray()
             ) {
                if (isDigit(ch)){
                    if (out_nub == 0) {out_nub = ch;
                    System.out.println(out_nub);
                    System.out.println(ch);}
                    else {
                        out_nub *= 10 + (int) ch;
                    }
                }
        }
        return out_nub;
    }

    public Telephon(String brand, String my_number) {
        Random random = new Random();
        this.brand = brand;
        this.my_number = str_to_long(my_number);
        this.remembered_numbers = new int[0];
        this.count_calls = 0;
        this.tariff = 0.1 + random.nextDouble() * 0.9;
    }

    public Telephon(String brand, Long my_number, int[] remembered_numbers, int count_calls, double tariff) {
        this.brand = brand;
        this.my_number = my_number;
        this.remembered_numbers = remembered_numbers;
        this.count_calls = count_calls;
        this.tariff = tariff;
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

    public int[] getRemembered_numbers() {
        return remembered_numbers;
    }

    public void setRemembered_numbers(int[] remembered_numbers) {
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
        return "Telephon{" +
                "brand='" + brand + '\'' +
                ", my_number=" + my_number +
                ", remembered_numbers=" + Arrays.toString(remembered_numbers) +
                ", count_calls=" + count_calls +
                ", tariff=" + tariff +
                '}';
    }
}
