package com.ddd.ex.order.infra;

import com.ddd.ex.order.domain.CancelPolicy;
import com.ddd.ex.order.domain.Canceller;
import com.ddd.ex.order.domain.Order;

import org.springframework.stereotype.Component;

@Component
public class SecurityCancelPolicy implements CancelPolicy {

    @Override
    public boolean hasCancellationPermission(Order order, Canceller canceller) {
        // TODO: 추후 관리자는 제외
        return isCancellerOrderer(order, canceller);
    }

    private boolean isCancellerOrderer(Order order, Canceller canceller) {
        return order.getOrdered().getMemberId().getId().equals(canceller.getMemberId());
    }

}
