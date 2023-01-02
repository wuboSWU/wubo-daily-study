package spring5.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy {
    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};
        Object o = Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
    }

    public interface UserDao {
        public boolean add(int a);
    }

    public static class UserDaoImpl implements UserDao {
        @Override
        public boolean add(int a) {
            return a == 1;
        }
    }
}
