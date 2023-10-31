package com.searchtecnologia.recurso.service.util.query;

import com.searchtecnologia.recurso.service.util.query.filter.Filter;
import com.searchtecnologia.recurso.service.util.query.filter.RangeFilter;
import com.searchtecnologia.recurso.service.util.query.filter.StringFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;

public class QueryService<ENTITY> {

    public <X> Specification<ENTITY> buildSpecification(Filter<X> filter, SingularAttribute<? super ENTITY, X> field) {
        return buildSpecification(filter, root -> root.get(field));
    }

    public Specification<ENTITY> buildSpecification(StringFilter filter, SingularAttribute<? super ENTITY, String> field) {
        return buildSpecification(filter, root -> root.get(field));
    }

    public <X> Specification<ENTITY> buildSpecification(Filter<X> filter, Function<Root<ENTITY>, Expression<X>> metaclassFunction) {
        if (Objects.nonNull(filter.getEquals())) {
            return equalsSpecification(metaclassFunction, filter.getEquals());
        } else if (Objects.nonNull(filter.getIn())) {
            return valueIn(metaclassFunction, filter.getIn());
        }
        return null;
    }

    public Specification<ENTITY> buildSpecification(StringFilter filter, Function<Root<ENTITY>, Expression<String>> metaclassFunction) {
        if (Objects.nonNull(filter.getEquals())) {
            return equalsSpecification(metaclassFunction, filter.getEquals());
        } else if (Objects.nonNull(filter.getIn())) {
            return valueIn(metaclassFunction, filter.getIn());
        } else if (Objects.nonNull(filter.getContains())) {
            return likeUpperSpecification(metaclassFunction, filter.getContains());
        }
        return null;
    }

    public <X extends Comparable<? super X>> Specification<ENTITY> buildSpecification(RangeFilter<X> filter, Function<Root<ENTITY>, Expression<X>> metaclassFunction) {
        if (Objects.nonNull(filter.getEquals())) {
            return equalsSpecification(metaclassFunction, filter.getEquals());
        } else if (Objects.nonNull(filter.getIn())) {
            return valueIn(metaclassFunction, filter.getIn());
        }

        Specification<ENTITY> result = Specification.where(null);
        if (Objects.nonNull(filter.getGreaterThan())) {
            result = result.and(greaterThan(metaclassFunction, filter.getGreaterThan()));
        }
        if (Objects.nonNull(filter.getGreaterOrEqualThan())) {
            result = result.and(greaterThanOrEqualTo(metaclassFunction, filter.getGreaterOrEqualThan()));
        }
        if (Objects.nonNull(filter.getLessThan())) {
            result = result.and(lessThan(metaclassFunction, filter.getLessThan()));
        }
        if (Objects.nonNull(filter.getLessOrEqualThan())) {
            result = result.and(lessThanOrEqualTo(metaclassFunction, filter.getLessOrEqualThan()));
        }
        return result;
    }

    public <X> Specification<ENTITY> valueIn(Function<Root<ENTITY>, Expression<X>> metaclassFunction, final Collection<X> values) {
        return ((root, query, builder) -> {
            CriteriaBuilder.In<X> in = builder.in(metaclassFunction.apply(root));
            for (X value : values) {
                in = in.value(value);
            }
            return in;
        });
    }

    public <X> Specification<ENTITY> equalsSpecification(Function<Root<ENTITY>, Expression<X>> metaclassFunction, final X value) {
        return (root, query, builder) -> builder.equal(metaclassFunction.apply(root), value);
    }

    public Specification<ENTITY> likeUpperSpecification(Function<Root<ENTITY>, Expression<String>> metaclassFunction, final String value) {
        return (root, query, builder) -> builder.like(builder.upper(metaclassFunction.apply(root)), wrapLikeQuery(value));
    }

    public String wrapLikeQuery(String txt) {
        return "%" + txt.toUpperCase() + '%';
    }

    public <X extends Comparable<? super X>> Specification<ENTITY> greaterThan(Function<Root<ENTITY>, Expression<X>> metaclassFunction, final X value) {
        return (root, query, builder) -> builder.greaterThan(metaclassFunction.apply(root), value);
    }

    public <X extends Comparable<? super X>> Specification<ENTITY> greaterThanOrEqualTo(Function<Root<ENTITY>, Expression<X>> metaclassFunction, final X value) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(metaclassFunction.apply(root), value);
    }

    public <X extends Comparable<? super X>> Specification<ENTITY> lessThanOrEqualTo(Function<Root<ENTITY>, Expression<X>> metaclassFunction, final X value) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(metaclassFunction.apply(root), value);
    }

    public <X extends Comparable<? super X>> Specification<ENTITY> lessThan(Function<Root<ENTITY>, Expression<X>> metaclassFunction, final X value) {
        return (root, query, builder) -> builder.lessThan(metaclassFunction.apply(root), value);
    }
}