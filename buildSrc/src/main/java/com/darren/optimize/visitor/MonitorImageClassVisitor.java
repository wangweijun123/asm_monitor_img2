package com.darren.optimize.visitor;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static java.lang.System.out;

public class MonitorImageClassVisitor extends ClassVisitor {
    public MonitorImageClassVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM5, classVisitor);
    }

    /**
     * 访问类会进入这里
     */
    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        if(superName.equals("android/widget/ImageView")
                && !name.equals("com/darren/optimize/day04/MonitorImageView")){
            out.println("name:"+name+",replace superName:"+superName);
            superName = "com/darren/optimize/day04/MonitorImageView";
        }
        super.visit(version, access, name, signature, superName, interfaces);
    }

    /**
     * @param access
     * @param name
     * @param descriptor
     * @param signature
     * @param exceptions
     * @return
     */
    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
//        out.println("access:"+access+", ");
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }
}
