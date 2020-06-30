package org.nervos.huobi.service.admission_control.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Vector;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusList {
    private Vector<String> status;
}
