/**
 * 
 */
package com.csf.whoami.security.template;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.asiantech.mamakelly.dao.DailyDao;
import com.asiantech.mamakelly.dao.MenstruationDao;
import com.asiantech.mamakelly.dao.UsersDao;
import com.asiantech.mamakelly.entities.MenstruationEntity;
import com.asiantech.mamakelly.entities.UsersEntity;

/**
 * The type Ninkatsu Top service test.
 * 
 * @author at-tuandang
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MenstruationManageServiceImpl.class)
@TestPropertySource(properties = { "menstruation.ave.max=40", "menstruation.ave.min=22" })
public class NinkatsuTopTest2 {

    @Autowired
    private MenstruationManageServiceImpl menstruationManageService;
    @MockBean
    private MenstruationDao menstruationDao;

    @MockBean
    private DailyDao dailyDao;

    @MockBean
    private UsersDao usersDao;
    @MockBean
    private Environment env;

    private String userId = "4e28fd62-3093-4c7c-bf03-bfd2310e9ca2";

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void task727WhenCallGetNinkatsuTop() throws Exception {

//        List<String> mnstList = new ArrayList<>();
//        String avelageMenst = CommonTool.format(Timestamp.valueOf("2019-06-11 00:00:00"), "yyyy-MM-dd");
//        mnstList.add(avelageMenst);
//        
//        List<String> ovulList = new ArrayList<>();
//        String ovul = CommonTool.format(Timestamp.valueOf("2019-05-28 00:00:00"), "yyyy-MM-dd");
//        ovulList.add(ovul);
//
        List<MenstruationEntity> menstruationList = new ArrayList<>();
    	MenstruationEntity menstruationFirst = new MenstruationEntity();
    	menstruationFirst.setSerialId(new Integer(1155));
        menstruationFirst.setStartDateTime(Timestamp.valueOf("2019-05-01 00:00:00"));
        menstruationFirst.setEndDateTime(Timestamp.valueOf("2019-05-07 00:00:00"));
        menstruationFirst.setMenstruation(Timestamp.valueOf("2019-05-01 00:00:00"));
        menstruationFirst.setOvulation(Timestamp.valueOf("2019-04-17 00:00:00"));
        menstruationFirst.setIsDeleted(new Integer(0));

        MenstruationEntity menstruationSecond = new MenstruationEntity();
        menstruationSecond.setSerialId(new Integer(1156));
        menstruationSecond.setUserId(userId);
        menstruationSecond.setStartDateTime(Timestamp.valueOf("2019-05-28 00:00:00"));
        menstruationSecond.setEndDateTime(Timestamp.valueOf("2019-06-03 00:00:00"));
        menstruationSecond.setMenstruation(Timestamp.valueOf("2019-06-24 00:00:00"));
        menstruationSecond.setOvulation(Timestamp.valueOf("2019-06-10 00:00:00"));
        menstruationSecond.setIsDeleted(new Integer(0));

        menstruationList.add(menstruationSecond);
        menstruationList.add(menstruationFirst);

        UsersEntity users = new UsersEntity();
        users.setUserId(userId);
        
        Timestamp limitTime = Timestamp.valueOf("2019-03-17 14:41:01.272");
        
        Mockito.when(menstruationDao.findLastData(userId)).thenReturn(menstruationSecond);
        Mockito.when(menstruationDao.findByUseridandlimitdateOrderByStartdatetimedesc(
        		userId, limitTime)).thenReturn(new ArrayList<>());
        Mockito.when(usersDao.findByUserId(userId)).thenReturn(users);
        Mockito.when(menstruationDao.findByUseridandlimitenddateOrderByStartdatetimedesc(
        		Mockito.any(), Mockito.any())).thenReturn(menstruationList);

        List<String> response = menstruationManageService.completionAvelageMenst(userId, 
        		Timestamp.valueOf("2019-06-24 00:00:00.0"), Timestamp.valueOf("2019-07-17 00:00:00.0"));

        Assert.assertNotNull(response);
    }

}
