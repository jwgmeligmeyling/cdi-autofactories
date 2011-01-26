package pl.softwaremill.common.sqs.task;

/**
 * @author Adam Warski (adam at warski dot org)
 */
public interface TaskExecutor<T extends Task<T>> {
    void execute(T task);
}
