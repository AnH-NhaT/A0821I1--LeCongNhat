package case_study_furama.model;

import case_study_furama.util.ConstantUtil;
import case_study_furama.util.ConstantUtil.TypeCustomer;

public class Customer extends Person {
    private TypeCustomer typeCustomer;

    public Customer() { }

    public Customer(int id, String code, String fullName, String birthday, ConstantUtil.Gender gender, String phone,
                    String email, String address, TypeCustomer typeCustomer) {
        super(id, code, fullName, birthday, gender, phone, email, address);
        this.typeCustomer = typeCustomer;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public boolean equals(Object o) {
        return getId()== ((Customer)o).getId();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", code='" + getCode() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", birthday='" + getBirthday() + '\'' +
                ", gender=" + getGender() +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", address='" + getAddress() + '\'' +
                "typeCustomer=" + typeCustomer +
                '}';
    }
}
