package com.bang.MyCode;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Title:
 * Description:
 * Company: 三峡高科
 *
 * @Author: lixibang
 * @Data by 2019年06月13日 18:17.
 */
@RunWith(Arquillian.class)
public class NarcissisticNumberTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(NarcissisticNumber.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

  @org.junit.Test
  public void narcissistic() {}
}
