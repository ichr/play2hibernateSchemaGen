package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import play.db.jpa.*;

/**
 * Company entity managed by JPA
 */
@Entity 
public class Company extends BaseModel {
    public static BaseModel.Finder<Long,Company> finder = new BaseModel.Finder(Long.class, Company.class);

    @Constraints.Required
    public String name;

    public static Map<String,String> options() {
        List<Company> companies = finder.find("from Company order by name").getResultList();
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Company c: companies) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }

}

