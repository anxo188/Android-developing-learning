package anxo.mytodotasklist;

public class Task {

    private String taskName;
    private Boolean finished;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString(){
        return this.taskName;
    }
}
