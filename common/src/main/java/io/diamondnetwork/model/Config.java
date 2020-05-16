package io.diamondnetwork.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Config implements Serializable {
    private static final long serialVersionUID = -1L;
    private long       id;
    private String      confName;
    private String      confValue;
    private String      comment;
}
