# Getting Started

This is meant as simple example of spring boot project setup that seems to work for mee and keep using it on multiple projects

# Liquibase

Liquibase is set up to run all scripts from db/changelog folder. There is an ant task to create migration script so they keep the same naming/format.

To generate liquibase change set just run 

`mvn antrun:run@changeset -Dchange_name=<name>`

name should be descriptive of changes made to the database, for example alter/create_user. No spaces allowed.