package com.oblivioussp.spartanweaponry.item;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.entity.projectile.ThrowingWeaponEntity;
import com.oblivioussp.spartanweaponry.entity.projectile.TomahawkEntity;
import com.oblivioussp.spartanweaponry.init.ModSounds;
import com.oblivioussp.spartanweaponry.util.Defaults;
import com.oblivioussp.spartanweaponry.util.WeaponArchetype;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TomahawkItem extends ThrowingWeaponItem 
{

	public TomahawkItem(Item.Properties prop, WeaponMaterial material, WeaponArchetype archetypeIn,
			float weaponBaseDamage)
	{
		super(prop, material, archetypeIn, weaponBaseDamage, Defaults.DamageMultiplierTomahawk, Defaults.MeleeSpeedTomahawk,
				Defaults.MaxAmmoTomahawk, Defaults.ChargeTicksTomahawk);
		this.throwVelocity = 1.75f;
	}
	
	public TomahawkItem(Item.Properties prop, WeaponMaterial material, WeaponArchetype archetypeIn,
			float weaponBaseDamage, String customDisplayName)
	{
		this(prop, material, archetypeIn, weaponBaseDamage);
		if(material.useCustomDisplayName())
			this.customDisplayName = customDisplayName;
	}

	@Override
	public ThrowingWeaponEntity createThrowingWeaponEntity(Level level, Player player, ItemStack stack, int charge) 
	{
		return new TomahawkEntity(level, player);
	}
	
	@Override
	protected SoundEvent getThrowingSound() 
	{
		return ModSounds.TOMAHAWK_THROW.get();
	}
}
