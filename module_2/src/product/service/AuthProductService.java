package product.service;

import product.common.FileProcessing;
import product.common.NotFoundProductException;
import product.model.AuthProduct;

import java.util.ArrayList;
import java.util.List;

public class AuthProductService {
    private static final String PATH_AUTH = "src/product/data/AuthProduct.csv";
    private static final String COMMA = ",";
    private static final String FIRST_LINE = "//id,name,cost,producer,maintenance";

    public void add(AuthProduct authProduct) {
        int size = scanFile().size();
        if (size == 0) {
            authProduct.setId(size + 1);
        } else {
            authProduct.setId(scanFile().get(size - 1).getId() + 1);
        }
        String line = authProduct.getId() +
                COMMA + authProduct.getName() +
                COMMA + authProduct.getCost() +
                COMMA + authProduct.getProducer() +
                COMMA + authProduct.getMaintenance();
        FileProcessing.writeFile(PATH_AUTH, line, FIRST_LINE);
        scanFile().add(authProduct);
    }

    public List<AuthProduct> scanFile() {
        List<String> listLine = FileProcessing.readFile(PATH_AUTH);
        String[] lineSplit;
        List<AuthProduct> list = new ArrayList<>();
        for (String s : listLine) {
            AuthProduct authProductNew = new AuthProduct();
            lineSplit = s.split(COMMA);
            if (lineSplit.length == 5) {
                authProductNew.setId(Integer.parseInt(lineSplit[0]));
                authProductNew.setName(lineSplit[1]);
                authProductNew.setCost(Integer.parseInt(lineSplit[2]));
                authProductNew.setProducer(lineSplit[3]);
                authProductNew.setMaintenance(Integer.parseInt(lineSplit[4]));
                list.add(authProductNew);
            }
        }
        return list;
    }

    public void rewrite() {
        FileProcessing.emptyFile(PATH_AUTH);
        for (AuthProduct e : scanFile()) {
            String line = e.getId() +
                    COMMA + e.getName() +
                    COMMA + e.getCost() +
                    COMMA + e.getProducer() +
                    COMMA + e.getMaintenance();
            FileProcessing.writeFile(PATH_AUTH, line, FIRST_LINE);
        }
    }

    public List<AuthProduct> getAll() {
        return scanFile();
    }

    public boolean delete(int id) {
        if (!scanFile().removeIf(e -> e.getId() == id))
            return false;
        rewrite();
        return true;
    }

    public List<AuthProduct> find(String name) throws NotFoundProductException {
        List<AuthProduct> newList = new ArrayList<>();
        boolean isFound = true;
        for (AuthProduct authProduct : scanFile()) {
            if (authProduct.getName().contains(name)) {
                newList.add(authProduct);
                isFound = false;
            }
        }
        if (isFound) {
            throw new NotFoundProductException("Not found!");
        }
        return newList;
    }

}