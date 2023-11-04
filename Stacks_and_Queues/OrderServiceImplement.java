/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Stacks_and_Queues;

public class OrderServiceImplement implements OrderService {

    int n = 2;

    @Override
    public void create() {
        System.out.println("create  1");
    }

    @Override
    public void cancel() {
        System.out.println("cancel  1");
    }

    @Override
    public void send() {
        System.out.println("send  1");
    }
}
