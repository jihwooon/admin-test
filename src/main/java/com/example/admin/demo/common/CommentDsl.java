package com.example.admin.demo.common;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDsl {
  public static JPAQueryFactory jpaQueryFactory;

  public CommentDsl(JPAQueryFactory queryFactory) {
    super();
    this.jpaQueryFactory = queryFactory;
  }

  public static Long getTotalCount(Predicate[] predicatesCondition, EntityPath<?> args) {
      return jpaQueryFactory.select(Wildcard.count)
          .from(args)
          .where(predicatesCondition)
          .fetch().get(0);
    }
}
