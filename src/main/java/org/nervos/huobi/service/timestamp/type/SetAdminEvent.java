package org.nervos.huobi.service.timestamp.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.jvm.hotspot.debugger.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetAdminEvent {
    private Address admin;
}
