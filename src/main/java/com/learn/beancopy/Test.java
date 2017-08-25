package com.learn.beancopy;

import com.learn.beancopy.dest.InnerClassB;
import com.learn.beancopy.dest.RedBabyOrderDetailVo;
import com.learn.beancopy.dest.Woman;
import com.learn.beancopy.source.InnerClassA;
import com.learn.beancopy.source.Man;
import com.learn.beancopy.source.RedBabyOrderDetailDto;
import com.learn.beancopy.source.RedBabySrvCommdtyInfoDto;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * net.sf.dozer.dozer测试类
 */
public class Test {

    public static void main(String[] args) throws  Exception {

        RedBabyOrderDetailDto redBabyOrderDetailDto = new RedBabyOrderDetailDto();
        redBabyOrderDetailDto.setStoreCode("837A");
        redBabyOrderDetailDto.setMdh("M000129133");
        redBabyOrderDetailDto.setDh("D00923238");
        redBabyOrderDetailDto.setCmmdtyCode("108554563");
        redBabyOrderDetailDto.setCmmdtyName("测试商品7");
        redBabyOrderDetailDto.setCmmdtyPrice(new BigDecimal(10));
        redBabyOrderDetailDto.setCmmdtyQuantity(new BigDecimal(1));
        redBabyOrderDetailDto.setCmmdtyGroup("01");
        redBabyOrderDetailDto.setCmmdtyBrand("02");
        redBabyOrderDetailDto.setCmmdtyType("01");
        redBabyOrderDetailDto.setCmmdtyEan("123456");
        redBabyOrderDetailDto.setSaleUnit("02");
        redBabyOrderDetailDto.setOrderLineAmount(new BigDecimal(10));
        redBabyOrderDetailDto.setDeliveryAddress("南京");
        redBabyOrderDetailDto.setSapOrdType("01");
        redBabyOrderDetailDto.setPlace("025");
        redBabyOrderDetailDto.setStorage("025");
        redBabyOrderDetailDto.setSupplier("55645454");
        redBabyOrderDetailDto.setDeliveryType("01");
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        redBabyOrderDetailDto.setInstallDate(StringUtils.substring(date, 0, 8));
        redBabyOrderDetailDto.setInstallTime(StringUtils.substring(date, 8));
        redBabyOrderDetailDto.setDeliveryDate(StringUtils.substring(date, 0, 8));
        redBabyOrderDetailDto.setDeliveryTime(StringUtils.substring(date, 8));
        redBabyOrderDetailDto.setSendingMark("");
        redBabyOrderDetailDto.setLoadingMark("");
        redBabyOrderDetailDto.setPurchaseFlag("01");
        redBabyOrderDetailDto.setInvoiceType("01");
        redBabyOrderDetailDto.setInvoiceTitle("顾客");
        redBabyOrderDetailDto.setTaxpayerId("5454545");
        redBabyOrderDetailDto.setCheckCode("55555");
        redBabyOrderDetailDto.setExistSrvCmmdty("1");
        RedBabySrvCommdtyInfoDto redBabySrvCommdtyInfoDto = new RedBabySrvCommdtyInfoDto();
        redBabySrvCommdtyInfoDto.setStoreCode("837A");
        redBabySrvCommdtyInfoDto.setDh("D00923238");
        redBabySrvCommdtyInfoDto.setCmmdtyCode("45545445");
        redBabySrvCommdtyInfoDto.setCmmdtyName("测试");
        redBabySrvCommdtyInfoDto.setCmmdtyBrand("21");
        redBabySrvCommdtyInfoDto.setCmmdtyGroup("01");
        redBabySrvCommdtyInfoDto.setCmmdtyType("02");
        redBabySrvCommdtyInfoDto.setCmmdtyEan("1224154");
        redBabySrvCommdtyInfoDto.setSaleUnit("873A");
        redBabySrvCommdtyInfoDto.setSupplierCode("154545");
        redBabySrvCommdtyInfoDto.setCmmdtyQty(new BigDecimal(1));
        redBabySrvCommdtyInfoDto.setDeliveryDate(StringUtils.substring(date, 0, 8));
        redBabySrvCommdtyInfoDto.setDeliveryTime(StringUtils.substring(date, 8));
        redBabySrvCommdtyInfoDto.setInstallDate(StringUtils.substring(date, 0, 8));
        redBabySrvCommdtyInfoDto.setInstallTime(StringUtils.substring(date, 8));
        redBabySrvCommdtyInfoDto.setServiceAddress("江苏省南京市玄武区");
        redBabySrvCommdtyInfoDto.setIntegratedDeliveryMark(StringUtils.EMPTY);
        redBabySrvCommdtyInfoDto.setServiceArea("025");
        redBabySrvCommdtyInfoDto.setServiceMemo(StringUtils.EMPTY);
        redBabyOrderDetailDto.setRedBabySrvCommdtyInfoDto(redBabySrvCommdtyInfoDto);

        List<RedBabySrvCommdtyInfoDto> redBabySrvCommdtyInfoDtos = new ArrayList<>();
        redBabySrvCommdtyInfoDtos.add(redBabySrvCommdtyInfoDto);
        redBabyOrderDetailDto.setRedBabySrvCommdtyInfoDtos(redBabySrvCommdtyInfoDtos);
        redBabyOrderDetailDto.setAge("23");
        int total = 100000;
        Mapper mapper = new DozerBeanMapper();
        RedBabyOrderDetailVo redBabyOrderDetailVo = new RedBabyOrderDetailVo();
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            mapper.map(redBabyOrderDetailDto, RedBabyOrderDetailVo.class);
        }
        System.out.println("Dozer cost time = " + (System.currentTimeMillis() - start));

        System.out.println(mapper.map(redBabyOrderDetailDto, RedBabyOrderDetailVo.class));


        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(RedBabyOrderDetailDto.class, RedBabyOrderDetailVo.class).field("redBabySrvCommdtyInfoDto", "redBabySrvCommdtyInfoVo").field("redBabySrvCommdtyInfoDtos", "redBabySrvCommdtyInfoVos").byDefault().register();
        MapperFacade orikaMapper = mapperFactory.getMapperFacade();
        start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            orikaMapper.map(redBabyOrderDetailDto, RedBabyOrderDetailVo.class);
        }
        System.out.println("orika cost time = " + (System.currentTimeMillis() - start));
        System.out.println(orikaMapper.map(redBabyOrderDetailDto, RedBabyOrderDetailVo.class));


        InnerClassA innerClassA = new InnerClassA();
        innerClassA.setSex(1);
        InnerClassA.ClassA classA = new InnerClassA().new ClassA();
        classA.setAge(23);
        classA.setName("zhangsan");
        innerClassA.setClassA(classA);

        MapperFactory mapperFactory1 = new DefaultMapperFactory.Builder().build();
        mapperFactory1.classMap(InnerClassA.class, InnerClassB.class).field("classA", "classB").byDefault().register();
        MapperFacade orikaMapper1 = mapperFactory.getMapperFacade();
        System.out.println(orikaMapper1.map(innerClassA, InnerClassB.class));


        Man man = new Man();
        man.setSex("male");
        man.setAge(20);
        man.setName("lilei");
        MapperFactory mapperFactory2 = new DefaultMapperFactory.Builder().build();
        MapperFacade mapperFacade = mapperFactory2.getMapperFacade();
        System.out.println(mapperFacade.map(man, Woman.class));
    }
}
