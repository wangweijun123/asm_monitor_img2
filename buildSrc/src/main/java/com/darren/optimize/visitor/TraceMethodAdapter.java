package com.darren.optimize.visitor;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

import static java.lang.System.out;

public class TraceMethodAdapter extends AdviceAdapter {

    private final String methodName;
    private final String name;
    private final String className;
    private final boolean isMethodBeatClass;

    protected TraceMethodAdapter(int api, MethodVisitor mv, int access, String name, String desc, String className,
                                 boolean isMethodBeatClass) {
        super(api, mv, access, name, desc);
        this.methodName = name;
        this.isMethodBeatClass = isMethodBeatClass;
        this.className = className;
        this.name = name;
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
//        out.println("owner -> "+owner+", name -> "+name+", descriptor -> "+descriptor);
        super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        super.visitVarInsn(opcode, var);

    }

    @Override
    protected void onMethodEnter() {
        out.println(className + " " + methodName + " onMethodEnter");
    }

    @Override
    protected void onMethodExit(int opcode) {
        out.println(className + " " + methodName + " onMethodExit");
        if(methodName.equals("onCreate") && "com/darren/optimize/day04/MainActivity".equals(className)){
            System.out.println("modify code########### -> ");
            // 参数怎么写 (使用字节码工具ASM Bytecode Outline,先把要插入的代码写好，然后copy到插件中来)
            mv.visitLdcInsn("MonitorImageView");
            mv.visitLdcInsn("enterMethod");
            // 这里一定是要字节码的方法
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "android/util/Log", "e",
                    "(Ljava/lang/String;Ljava/lang/String;)I", false);
        }
    }
}