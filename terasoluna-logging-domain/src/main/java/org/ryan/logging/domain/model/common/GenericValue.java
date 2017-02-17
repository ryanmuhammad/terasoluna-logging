package org.ryan.logging.domain.model.common;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Iriyanto.Perkasa on 1/24/2017.
 */
@Data
@ToString
public class GenericValue implements Serializable{

    private static final long serialVersionUID = 1L;

    private String nameValue;
    private Object value;

    public GenericValue(String nameValue, Object value) {
        super();
        this.nameValue = nameValue;
        this.value = value;
    }

}
