package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    /*
     * A ideia de usar um Factory é de não expor implementação.
     * Então temos a interface EntidadeDAO, que terá seus métodos obrigatórios.
     * Depois temos um pacote de Implementações (Impl) com as classes extendendo as interfaces
     * Essas Implementações pode ser do tipo JDBC, Hibernate, etc.
     * Depois temos a DAO factory que retorna uma instância da implementação mas do tipo Interface (Up-Scalling).
     * E por quê não instanciar diretamente a implementação? Para ajudar no desacoplamento e manutenção.
     * Ex.: se tivermos que mudar a forma de implementação de JDBC para Hibernate, imagina a quantidade de
     *  locais que teria que ser alterado? Se todos instanciam o Factory, basta mudar lá.
     * Isso traz o princípio de que cada classe é responsável por si, ou seja, eu como Program
     *   quero uma instância de SellerDao para iniciar as mexidas na base,
     *   e não quero saber como é implementado e por quem ou onde.
     * Nota: Injeção de Dependência
     * */
    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
