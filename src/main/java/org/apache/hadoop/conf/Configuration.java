package org.apache.hadoop.conf;

public class Configuration {

    public Configuration() {
        this(true);
    }
    public Configuration(boolean useDefaults) {}

    public boolean getBoolean(String x, boolean y) {
        return y;
    }

    public void setBoolean(String x, boolean y) {
    }

    public int getInt(String x, int y) {
        return y;
    }

    public String get(String x) {
        return null;
    }

    public ClassLoader getClassLoader() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = Configuration.class.getClassLoader();
        }
        return classLoader;
    }
}
