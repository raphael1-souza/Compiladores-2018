.source prog_destino.java 
.class public teste06
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static main([Ljava/lang/String;)V 
.limit stack 13 
.limit locals 7
ldc2_w 1.0
dstore_1
ldc2_w 0.0
dstore_3
LABELINICIOENQUANTO_14:
dload_1
ldc2_w 10.0
dcmpg 
iflt COLOCATRUE_15
dconst_0 
goto SAIDA_16
COLOCATRUE_15:
dconst_1 
SAIDA_16:
dload_1
ldc2_w 15.0
dcmpg 
ifeq COLOCATRUE_17
dconst_0 
goto SAIDA_18
COLOCATRUE_17:
dconst_1 
SAIDA_18:
dconst_0 
dcmpg 
ifeq SAIDA_19
pop2 
dconst_1 
SAIDA_19:
dconst_0 
dcmpg 
ifeq LABELFALSE_13

dload_1
ldc2_w 9.0
dcmpg 
ifeq COLOCATRUE_8
dconst_0 
goto SAIDA_9
COLOCATRUE_8:
dconst_1 
SAIDA_9:
dload_1
ldc2_w 0.0
dcmpg 
ifeq COLOCATRUE_10
dconst_0 
goto SAIDA_11
COLOCATRUE_10:
dconst_1 
SAIDA_11:
dconst_0 
dcmpg 
ifeq SAIDA_12
pop2 
dconst_1 
SAIDA_12:
dconst_0 
dcmpg 
ifeq LABELFALSE_7

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Digite um valor para x - Valores menores que 20 ou igual 99 -"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
LABELINICIOENQUANTO_1:
dload_3
ldc2_w 99.0
dcmpg 
ifeq COLOCATRUE_2
dconst_0 
goto SAIDA_3
COLOCATRUE_2:
dconst_1 
SAIDA_3:
dload_3
ldc2_w 20.0
dcmpg 
iflt COLOCATRUE_4
dconst_0 
goto SAIDA_5
COLOCATRUE_4:
dconst_1 
SAIDA_5:
dconst_0 
dcmpg 
ifeq SAIDA_6
pop2 
dconst_1 
SAIDA_6:
dconst_0 
dcmpg 
ifeq LABELFALSE_0

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Digite 99 ou menor que 20 para permanecer"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextDouble()D 
dstore_3
goto LABELINICIOENQUANTO_1

LABELFALSE_0:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Saindo do teste interno"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
LABELFALSE_7:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Digite um valor para n - Menor que 10 ou igual 15 -"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "Digite 9 ou 0 para entrar no teste interno "
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
new java/util/Scanner 
dup 
getstatic java/lang/System.in Ljava/io/InputStream; 
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V 
invokevirtual java/util/Scanner.nextDouble()D 
dstore_1
goto LABELINICIOENQUANTO_14

LABELFALSE_13:
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "\nFim do enquanto. O valor de n = "
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_1
invokevirtual java/io/PrintStream/println(D)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "O valor de x = "
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V 
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload_3
invokevirtual java/io/PrintStream/println(D)V 
return 
.end method 
