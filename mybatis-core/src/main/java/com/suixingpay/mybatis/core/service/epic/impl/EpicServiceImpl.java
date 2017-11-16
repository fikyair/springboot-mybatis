package com.suixingpay.mybatis.core.service.epic.impl;

import com.suixingpay.common.core.orm.dao.GenericDao;
import com.suixingpay.common.core.service.AbstractService;
import com.suixingpay.mybatis.core.orm.epic.domain.Epic;
import com.suixingpay.mybatis.core.orm.epic.domain.EpicQuery;
import com.suixingpay.mybatis.core.orm.epic.mapper.EpicMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fisherman on 2017/11/8.
 */
@Service
@Slf4j
public class EpicService extends AbstractService<Epic, String> {

    @Autowired
    private EpicMapper epicMapper;


    public void save(Epic epic) {

        SimpleDateFormat sysTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        epic.setCreateEpicDate(sysTime.format(new Date()));
        epic.setDemandAnalEndDate(epic.getDemandAnalStartDate());
        epic.setDemandAnalStartDate(epic.getDemandAnalStartDate());
        epic.setDemandCollDate(epic.getDemandCollDate());
        epic.setDescript(epic.getDescript());
        epic.setEpicId(epic.getEpicId());
        epic.setEpicName(epic.getEpicName());
        epic.setManagers(epic.getManagers());
        epic.setModiEpicDate(sysTime.format(new Date()));
        epic.setOperationDept(epic.getOperationDept());
        epic.setPriority(epic.getPriority());
        epic.setProjectName(epic.getProjectName());
        epic.setProposer(epic.getProposer());
        epic.setQuestionType(epic.getQuestionType());
        epic.setReporter(epic.getReporter());
        epic.setTopic(epic.getTopic());
        epic.setStatus(epic.getStatus());

        epicMapper.save(epic);
    }

    public List<EpicQuery> epicQuery(EpicQuery epicQuery) {

        List<EpicQuery> list = epicMapper.epicQuery(epicQuery);

        return list;
    }

    @Override
    protected GenericDao<Epic, String> getDao() {
        return null;
    }

    public List<Epic> findAllEpic() {
        return epicMapper.findAllEpic();
    }

    public List<Epic> findOneEpic(String epicId) {

        return epicMapper.findOneEpic(epicId);
    }
}
