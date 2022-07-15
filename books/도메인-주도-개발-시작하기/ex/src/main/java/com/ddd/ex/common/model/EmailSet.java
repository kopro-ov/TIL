package com.ddd.ex.common.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EmailSet {

    private Set<Email> emails = new HashSet<>();

    protected EmailSet() {

    }

    private EmailSet(Set<Email> emails) {
        this.emails = emails;
    }

    public static EmailSet of(Set<Email> emails) {
        return new EmailSet(emails);
    }

    public Set<Email> getEmails() {
        /**
         * 이메일 주소 목록을 수정 할 수 없는 "읽기 전용"보기로 반환
         */
        return Collections.unmodifiableSet(emails);
    }
}
