package module_2.no17_serialization_binary_file.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> productList = new ArrayList<>();
    public final String PATH = "src/module_2/no17_serialization_binary_file/exercise/product.csv";

    public void writeFile(List<Product> list) {
        try {
            FileOutputStream fos = new FileOutputStream(PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> readFile() {
        try {
            File file = new File(PATH);
            if (file.length() != 0) {
                FileInputStream fis = new FileInputStream(PATH);
                ObjectInputStream ois = new ObjectInputStream(fis);
                productList = (List<Product>) ois.readObject();
                ois.close();
                fis.close();
            } else
                System.out.println("File is empty!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public void add(Product product) {
        File file = new File(PATH);
        if (file.length() == 0)
            productList.add(product);
        else
            readFile().add(product);
        writeFile(productList);
    }

    public List<Product> getAll() {
        return readFile();
    }

    public void find(String name) {
        boolean is = true;
        for (Product f : readFile()) {
            if (f.getName().contains(name)) {
                System.out.println(f);
                is = false;
            }
        }
        if (is)
            System.out.println("NOT FOUND!");
    }
}
