.source prog_destino.java 
.class public exemplo13
.super java/lang/Object 
.method public <init>()V 
.limit stack 1 
.limit locals 1 
aload_0 
invokespecial java/lang/Object/<init>()V 
return 
.end method 

.method public static main([Ljava/lang/String;)V 
.limit stack 9 
.limit locals 9
ldc2_w 2.0
ldc2_w 3.0
dadd 
dstore_1
ldc2_w 5.0
dstore_3
dload_3
dstore 5
getstatic java/lang/System/out Ljava/io/PrintStream; 
dload 5
invokevirtual java/io/PrintStream/print(D)V 
ldc2_w 1.0
ldc2_w 3.0
dcmpg 
ifeq COLOCATRUE_1
dconst_0 
goto SAIDA_2
COLOCATRUE_1:
dconst_1 
SAIDA_2:
ldc2_w 3.0
ldc2_w 1.0
dcmpg 
ifeq COLOCATRUE_3
dconst_0 
goto SAIDA_4
COLOCATRUE_3:
dconst_1 
SAIDA_4:
dconst_0 
dcmpg 
ifeq SAIDA_5
dconst_1 
dcmpg 
ifeq AUX_6
dconst_1 
goto SAIDA_5
AUX_6:
dconst_0 
SAIDA_5:
dconst_0 
dcmpg 
ifeq LABELFALSE_0

getstatic java/lang/System/out Ljava/io/PrintStream; 
ldc "XOR deu bom"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V 
LABELFALSE_0:
return 
.end method 
