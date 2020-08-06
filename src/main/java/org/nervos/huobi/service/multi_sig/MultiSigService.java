package org.nervos.huobi.service.multi_sig;

import org.nervos.huobi.Huobi;

public class MultiSigService extends org.nervos.muta.service.multi_sig.MultiSigService {
    public MultiSigService(Huobi huobi) {
        super(huobi);
    }

    public Huobi getHuobi() {
        return (Huobi) this.getMuta();
    }
}
