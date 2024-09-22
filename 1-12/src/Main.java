import java.util.ArrayList;
import java.util.Arrays;

// Класс моих функций
class Function{
    public  static <T> void print_arrayList(ArrayList<T> telephons){
        for (T telephon:telephons){
            System.out.println(telephon.toString());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Telephon> telephons = new ArrayList<>();

        ArrayList<Long> remembered_numbers1 = new ArrayList<Long>();
        remembered_numbers1.add(9341294283L);
        remembered_numbers1.add(9646215252L);
        remembered_numbers1.add(9526432337L);
        remembered_numbers1.add(9576435441L);

        telephons.add(new Telephon("iphone XS", "(903)472-99-36"));
        telephons.add(new Telephon("iphone 15"));
        telephons.add(new Telephon("iphone 16 Pro Max", "(952)642-52-52", remembered_numbers1, 0, 0.1));
        telephons.add(new Telephon("iphone 16 Plus", "(912)523-53-12", new ArrayList<Long>(Arrays.asList(5235231421L, 8494730074L, 1739572371L)), 0, 0.3));
        Function.print_arrayList(telephons);
    }
}
