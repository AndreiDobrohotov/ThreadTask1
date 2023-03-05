package model.Operations;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

//класс родитель для всех математических операций с вложеным полем Future
//для удобства вывода
public abstract class CallableWithFuture implements Callable<Long> {

    private Future<Long> future;

    public Future<Long> getFuture() {
        return future;
    }

    public void setFuture(Future<Long> future) {
        this.future = future;
    }
}
