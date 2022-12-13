package day7;

import java.util.*;
import java.util.stream.Collectors;

public class File {

    private final String name;
    private final File parent;
    private int size;
    private Map<String, File> children;

    public File(String name, File parent) {
        this.name = name;
        this.parent = parent;
        this.children = new HashMap<>();
    }

    public File(String name, File parent, int size) {
        this.name = name;
        this.parent = parent;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public File getParent() {
        return parent;
    }

    public File getChild(String name) {
        return children.get(name);
    }

    public void addChild(File f) {
        children.put(f.getName(), f);
    }

    public int getSize() {
        if (children == null) {
            return size;
        }
        return children.values().stream().map(File::getSize).reduce(Integer::sum).orElse(0);
    }

    public List<File> getDirs() {
        if (children == null) {
            return Collections.emptyList();
        }
        List<File> files = new ArrayList<>();
        files.add(this);
        List<List<File>> collect = children.values().stream().map(File::getDirs).collect(Collectors.toList());
        collect.forEach(files::addAll);
        return files;
    }
}
