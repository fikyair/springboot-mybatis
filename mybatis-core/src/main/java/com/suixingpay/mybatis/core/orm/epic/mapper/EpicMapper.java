package com.suixingpay.mybatis.core.orm.epic.mapper;

import com.suixingpay.common.core.orm.dao.GenericDao;
import com.suixingpay.mybatis.core.orm.epic.domain.Epic;
import com.suixingpay.mybatis.core.orm.epic.domain.EpicQuery;

import java.util.List;

/**
 * Created by fisherman on 2017/11/8.
 */
public interface EpicMapper extends GenericDao<Epic, String> {
    //继承后有封装好的save方法
    //void save(Epic epic);

    List<EpicQuery> epicQuery(EpicQuery epicQuery);

    List<Epic> findAllEpic();

    List<Epic> findOneEpic(String epicId);
}
