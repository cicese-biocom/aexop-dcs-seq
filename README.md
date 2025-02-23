# aexop-dcs-seq

[![API-Build And Release](https://github.com/cicese-biocom/aexop-dcs-seq/actions/workflows/maven_release.yml/badge.svg)](https://github.com/cicese-biocom/aexop-dcs-seq/actions/workflows/maven_release.yml)

### How to execute

```shell
    java -jar .\aexop-dcs-seq-0.0.4.jar -h
usage: cmd [-c <arg>] [-e <arg>] [-f <arg>] [-h] [-i] [-p <arg>] [-v]
-c,--csvfile <arg>     output, path to csv file
-e,--endpoint <arg>    csv file with a column with the target property for sequence
-f,--fastafile <arg>   input, path to sdf file
-h,--help              Show this help and exit
-i,--info              print project configuration
-p,--project <arg>     path to project file in json format (.json)
-v,--version           show the version and exit
```

### Example

```shell
java -jar aexop-dcs-seq-0.0.4.jar -p "files_examples\project.json" -f "files_examples\training.fasta" -c "salida\out.csv" -e "files_examples\training.fasta_class.csv"
```