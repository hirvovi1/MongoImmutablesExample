package fi.mongo.training;

import org.immutables.mongo.repository.RepositorySetup;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class TreeFacade {

    private final TreeRepository trees;

    public TreeFacade(RepositorySetup setup) {
        this.trees = new TreeRepository(setup);
    }

    public void addOrUpdate(Tree tree){
        trees.upsert(tree);
    }

    public List<Tree> listAllTrees() throws ExecutionException, InterruptedException {
        return trees.findAll().orderByHeight().fetchAll().get();
    }

    public void delete(Tree tree){
       trees.findById(tree.id()).deleteFirst();
    }

    public ImmutableTree.Builder builder(){
        return ImmutableTree.builder();
    }

}
