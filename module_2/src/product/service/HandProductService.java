package product.service;

import product.common.FileProcessing;
import product.common.NotFoundProductException;
import product.model.HandProduct;

import java.util.ArrayList;
import java.util.List;

public class HandProductService {

    private static final String PATH_HAND = "src/product/data/HandProduct.csv";
    private static final String COMMA = ",";
    private static final String FIRST_LINE = "//id,name,cost,producer,nation,status";

    public void add(HandProduct handProduct) {
        int size = scanFile().size();
        if (size == 0) {
            handProduct.setId(size + 1);
        } else {
            handProduct.setId(scanFile().get(size - 1).getId() + 1);
        }

        String line = handProduct.getId() +
                COMMA + handProduct.getName() +
                COMMA + handProduct.getCost() +
                COMMA + handProduct.getProducer() +
                COMMA + handProduct.getNation() +
                COMMA + handProduct.getStatus();
        FileProcessing.writeFile(PATH_HAND, line, FIRST_LINE);
        scanFile().add(handProduct);
    }

    public static List<HandProduct> scanFile() {
        List<String> listLine = FileProcessing.readFile(PATH_HAND);
        String[] lineSplit;
        List<HandProduct> list = new ArrayList<>();
        for (String s : listLine) {
            HandProduct handProductNew = new HandProduct();
            lineSplit = s.split(COMMA);
            if (lineSplit.length == 6) {
                handProductNew.setId(Integer.parseInt(lineSplit[0]));
                handProductNew.setName(lineSplit[1]);
                handProductNew.setCost(Integer.parseInt(lineSplit[2]));
                handProductNew.setProducer(lineSplit[3]);
                handProductNew.setNation(lineSplit[4]);
                handProductNew.setStatus(lineSplit[5]);
                list.add(handProductNew);
            }
        }
        return list;
    }

    public void rewrite() {
        FileProcessing.emptyFile(PATH_HAND);
        for (HandProduct handProduct : scanFile()) {
            String line = handProduct.getId() +
                    COMMA + handProduct.getName() +
                    COMMA + handProduct.getCost() +
                    COMMA + handProduct.getProducer() +
                    COMMA + handProduct.getNation() +
                    COMMA + handProduct.getStatus();
            FileProcessing.writeFile(PATH_HAND, line, FIRST_LINE);
        }
    }

    public List<HandProduct> getAll() {
        return scanFile();
    }

    public boolean delete(int id) {
        if (!scanFile().removeIf(e -> e.getId() == id))
            return false;
        rewrite();
        return true;
    }

    public List<HandProduct> find(String name) throws NotFoundProductException {
        List<HandProduct> newList = new ArrayList<>();
        boolean isFound = true;
        for (HandProduct handProduct : scanFile()) {
            if (handProduct.getName().contains(name)) {
                newList.add(handProduct);
                isFound = false;
            }
        }
        if (isFound) {
            throw new NotFoundProductException("Not found!");
        }
        return newList;
    }

}
