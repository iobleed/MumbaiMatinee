package com.plaxedo.MumbaiMatinee.data.repository;

import com.plaxedo.MumbaiMatinee.data.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemberRepository extends MongoRepository<Member, String> {

    public Member findByFirstName(String firstName);
    public List<Member> findByLastName(String lastName);
    public Member findByUserName(String userName);
}
