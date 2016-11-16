package com.rainbow.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

/**
 * Created by rainbow on 2016/11/16.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */

/**
 * @MappedSuperclass:表示他不是受管理的实体类，而是会根据其他的实体选择最合适的策略来生成主键
 * equals和hashCode方法，说明具有相同的id的同种类型的实体会被视为相等
 */

@MappedSuperclass
public class AbstractEntity {

    @Id
    @SequenceGenerator(name = "Any",sequenceName = "seq_name")
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity that = (AbstractEntity) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
