import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  private static final ArrayList<String> list = new ArrayList<>();
  private static final Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    String option;
    do {
      option = SafeInput.getRegExString(in, "Enter option [a|d|p|q]", "[AaDdPpQq]");
      if (option.equalsIgnoreCase("a")) {
        add();
      }
      if (option.equalsIgnoreCase("d") && list.size() > 0) {
        delete();
      }
      if (option.equalsIgnoreCase("p")) {
        print();
      }
      if (option.equalsIgnoreCase("q")) {
        if (quit()) {
          break;
        }
      }
    } while (true);
  }

  private static void add() {
    list.add(SafeInput.getNonZeroLenString(in, "Enter string to add to list"));
  }
  private static void delete() {
    int count = 0;
    for (String value : list) {
      count++;
      System.out.println(count + ": " + value);
    }
    if (list.size() == 1) {
      if (SafeInput.getYNConfirm(in, "Remove only index in list?")) {
        list.remove(0);
      }
    } else {
      list.remove(SafeInput.getRangedInt(in, "Enter index to remove", 1, list.size()) - 1);
    }
  }
  private static void print() {
    System.out.println(list);
  }
  private static boolean quit() {
    return SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
  }
}