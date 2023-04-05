package com.example.shortproject.entity;

public enum MemberRole {
    PROFESSOR("PROFESSOR"),
    STUDENT("STUDENT"),
    ADMIN("ADMIN")
    ;

    private final String memberRole;

    MemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getMemberRole() {
        return memberRole;
    }
}
