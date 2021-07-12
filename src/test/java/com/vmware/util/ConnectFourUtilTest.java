package com.vmware.util;

import com.vmware.ConnectFour;
import com.vmware.model.ConnectFourModel;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link ConnectFourUtil}
 *
 * @author  Srinath Tridandapani
 */
public class ConnectFourUtilTest {

    @Test
    public void testChooseAndDrop() {
        char symbol = 'X';
        ConnectFourModel connectFourModel = new ConnectFourModel(6, 8);
        ConnectFourUtil connectFourUtil = new ConnectFourUtil();
        ConnectFourModel returnedState = connectFourUtil.chooseAndDrop(symbol, 2, connectFourModel);

        Assert.assertNotNull(returnedState);
        Assert.assertEquals('X', returnedState.getGrid()[7][2]);
    }

    @Test
    public void testChooseAndDrop_InvalidInput() {
        char symbol = 'X';
        ConnectFourModel connectFour = new ConnectFourModel(6, 8);
        ConnectFourUtil connectFourUtil = new ConnectFourUtil();

        Assert.assertThrows(IllegalStateException.class, () -> connectFourUtil.chooseAndDrop(symbol, 9, connectFour));
    }


    @Test
    public void testIsWinningPlay() {
        char symbol1 = 'X';
        char symbol2 = 'O';
        ConnectFourModel connectFour = new ConnectFourModel(6, 8);
        ConnectFourUtil connectFourUtil = new ConnectFourUtil();
       connectFourUtil.chooseAndDrop(symbol1, 2, connectFour);
       connectFourUtil.chooseAndDrop(symbol2, 3, connectFour);
       connectFourUtil.chooseAndDrop(symbol1, 2, connectFour);
       connectFourUtil.chooseAndDrop(symbol2, 3, connectFour);
       connectFourUtil.chooseAndDrop(symbol1, 2, connectFour);
       connectFourUtil.chooseAndDrop(symbol2, 3, connectFour);
        connectFourUtil.chooseAndDrop(symbol1, 2, connectFour);
        ConnectFourModel returnedState = connectFourUtil.chooseAndDrop(symbol2, 3, connectFour);

        Assert.assertNotNull(returnedState);
        Assert.assertTrue(connectFourUtil.isWinningPlay(returnedState));
    }


}
