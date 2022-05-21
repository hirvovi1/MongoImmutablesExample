package fi.mongo.training;

import org.immutables.mongo.repository.RepositorySetup;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {

    public static final String CONNECTIONS_STRING = "mongodb://localhost/test";
    private final TreeFacade treeFacade = new TreeFacade(RepositorySetup.forUri(CONNECTIONS_STRING));

    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        makeBirchForest();
        addAspens();
        addSomeWillows();
        addOak();
        printForest();
    }

    private void addAspens() {
        for (int i = 0; i < 10; i++) {
            addAspenToRepository(1100 + i, i + 2);
        }
    }

    private void addAspenToRepository(int id, int height) {
        Tree tree = treeFacade.builder()
                .id(id).height(height)
                .species(TreeSpecies.ASPEN).build();
        treeFacade.addOrUpdate(tree);
    }

    private void addSomeWillows() {
        Tree tree = treeFacade.builder()
                .id(800).height(4)
                .species(TreeSpecies.WILLOW).build();
        treeFacade.addOrUpdate(tree);
    }

    private void addOak() {
        Tree tree = treeFacade.builder()
                .id(900).height(18)
                .species(TreeSpecies.OAK).build();
        treeFacade.addOrUpdate(tree);
    }

    private void makeBirchForest() {
        for (int i = 0; i < 30; i++) {
            addBirchToRepository(1 + i, i + 2);
        }
    }

    private void addBirchToRepository(int id, int height) {
        Tree tree = treeFacade.builder()
                .id(id).height(height)
                .species(TreeSpecies.BIRCH).build();
        treeFacade.addOrUpdate(tree);
    }

    private void printForest() {
        try {
            List<Tree> list = treeFacade.listAllTrees();
            for (Tree t: list) {
                System.out.println(t.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
